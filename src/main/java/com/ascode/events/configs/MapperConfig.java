package com.ascode.events.configs;

import com.ascode.events.converters.EstabelecimentoDtoToEstabelecimentoEntityConverter;
import com.ascode.events.converters.EstabelecimentoEntityToEstabelecimentoDtoConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(EstabelecimentoEntityToEstabelecimentoDtoConverter estabelecimentoEntityToEstabelecimentoDtoConverter,
                                   EstabelecimentoDtoToEstabelecimentoEntityConverter estabelecimentoDtoToEstabelecimentoEntityConverter){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(estabelecimentoEntityToEstabelecimentoDtoConverter);
        modelMapper.addConverter(estabelecimentoDtoToEstabelecimentoEntityConverter);

        return modelMapper;
    }
}
