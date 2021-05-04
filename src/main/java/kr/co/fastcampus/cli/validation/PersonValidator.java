package kr.co.fastcampus.cli.validation;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "empty");
        Person p = (Person) o;
        if(p.getAge() < 0) {
            e.rejectValue("age","negative value 0 down");
        } else if(p.getAge() > 110){
            e.rejectValue("age","negative value 110 up");
        }
    }
}
