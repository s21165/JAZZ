package pl.pjatk.WitJagi.RentalService.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateErrors implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (
                response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                        || response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new NotFoundException();
        }
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new BadRequestException();
        }
        if (response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
            throw new BadGatewayException();
        }
    }
}