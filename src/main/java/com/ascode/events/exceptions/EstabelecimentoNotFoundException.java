package com.ascode.events.exceptions;

import java.io.Serial;
import java.util.UUID;

public class EstabelecimentoNotFoundException extends NotFoundException{

    @Serial
    private static final long serialVersionUID = -7114487653197757339L;

    public EstabelecimentoNotFoundException(UUID uuid) {
        super(String.format("Not found estabelecimento with id %s", uuid));
    }

}
