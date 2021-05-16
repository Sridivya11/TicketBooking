package com.booktickets.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="No such Order")  // 404
public class NotFoundException extends RuntimeException{
}
