package com.ayatventure.ayatventure.game.mapper;

import com.ayatventure.ayatventure.game.DTO.GameDTO;
import com.ayatventure.ayatventure.mapper.JokerMapper;
import com.ayatventure.ayatventure.game.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = JokerMapper.class)
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(source = "game.user.username", target = "username")
    GameDTO gametoGameDto(Game game);
}
