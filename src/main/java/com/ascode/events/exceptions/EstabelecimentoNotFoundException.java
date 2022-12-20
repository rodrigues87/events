package com.ascode.events.exceptions;

import java.util.UUID;

public class EstabelecimentoNotFoundException extends NotFoundException{

    private static final long serialVersionUID = -7114487653197757339L;

    public EstabelecimentoNotFoundException(UUID uuid) {
        super(String.format("Not found estabelecimento with id %s", uuid));
    }

}
