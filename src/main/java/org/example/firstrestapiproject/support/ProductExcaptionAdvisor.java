package org.example.firstrestapiproject.support;

import org.example.firstrestapiproject.support.excaption.ProductNotFoundExcaption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import shared.response.api.ErrorMessageResponse;



@ControllerAdvice
public class ProductExcaptionAdvisor {
    private Logger LOG= (Logger) LoggerFactory.getLogger(ProductExcaptionAdvisor.class);
    @ExceptionHandler(ProductNotFoundExcaption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse productNotFoundExcaption(ProductNotFoundExcaption excaption){
        LOG.error(excaption.getMessage(),excaption);
        return new ErrorMessageResponse(excaption.getLocalizedMessage());
    }
}
