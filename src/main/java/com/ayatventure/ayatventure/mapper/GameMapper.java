package com.ayatventure.ayatventure.mapper;

import com.ayatventure.ayatventure.DTO.GameDTO;
import com.ayatventure.ayatventure.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = JokerMapper.class)
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(source = "game.user.username", target = "username")
    GameDTO gametoGameDto(Game game);
}
