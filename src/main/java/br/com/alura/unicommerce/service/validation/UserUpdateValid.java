package br.com.alura.unicommerce.service.validation;

import jakarta.validation.Payload;

public @interface UserUpdateValid {
	String message() default "Validation error";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
