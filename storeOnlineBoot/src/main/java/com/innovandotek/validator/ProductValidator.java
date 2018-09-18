package com.innovandotek.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.innovandotek.model.Product;


@Component
public class ProductValidator implements Validator {

	@SuppressWarnings("rawtypes")
	public boolean supports(Class clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	public void validate(Object object, Errors errors) {
		
		Product product = (Product)object;
		
		if (StringUtils.isEmpty(product.getName()))
		{
			errors.rejectValue("name", "product.name.required");
		}
		
		if(product.getPrice() == null
				|| StringUtils.isEmpty(product.getPrice().toString()))
		{
			errors.rejectValue("price", "product.price.required");		
		}
		
		if (StringUtils.isEmpty(product.getCode()))
		{
			errors.rejectValue("code", "product.code.required");
		}
		
		
	}

}
