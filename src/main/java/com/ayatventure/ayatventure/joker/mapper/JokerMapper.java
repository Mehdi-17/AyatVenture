package com.ayatventure.ayatventure.joker.mapper;

import com.ayatventure.ayatventure.joker.DTO.JokerDTO;
import com.ayatventure.ayatventure.game.mapper.GameMapper;
import com.ayatventure.ayatventure.joker.model.Joker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = GameMapper.class)
public interface JokerMapper {

    JokerMapper INSTANCE = Mappers.getMapper(JokerMapper.class);

    @Mapping(source = "used", target = "isUsed")
    JokerDTO jokerToJokerDTO(Joker joker);
}
