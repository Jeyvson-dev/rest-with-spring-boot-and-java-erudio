package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController{
	
	private static AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			)throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return convertToDouble(numberOne)+ convertToDouble(numberTwo);
		
	}
	
	@RequestMapping("/subtraction/{numberOne}/{numberTwo}")
	
	public Double subtraction(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) {
		
		if(!isNumeric(numberOne)||!isNumeric(numberTwo)) {
			
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
		
		
	}
	
	@RequestMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) {
		
		if(!isNumeric(numberOne)||!isNumeric(numberTwo)) {
			
			throw new UnsupportedMathOperationException("Please set a numeric value");
			
		}
		
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@RequestMapping("/division/{numberOne}/{numberTwo}")
	
	private Double division(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) {
		
		if(!isNumeric(numberOne)||!isNumeric(numberTwo)) {
			
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return convertToDouble(numberOne) / convertToDouble(numberTwo);	
		
		
	}

	private Double convertToDouble(String strNumber) {
		
		if(strNumber == null) return 0D;
		
		String number = strNumber.replaceAll(",", ".");
		
		if(isNumeric(strNumber)) return Double.parseDouble(number);
			
		
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		
		if(strNumber == null) return false;
		
		String number = strNumber.replaceAll(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		
		
	}
	
}
	
