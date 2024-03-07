package com.dreamscore.backend.mapper;

import com.dreamscore.backend.model.Pet;
import com.dreamscore.backend.model.User;
import com.dreamscore.backend.model.Visit;
import com.swagger.client.codegen.rest.model.PetDto;
import com.swagger.client.codegen.rest.model.UserDto;
import com.swagger.client.codegen.rest.model.VisitDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-07T23:33:28+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Azul Systems, Inc.)"
)
@Component
public class PetMapperImpl implements PetMapper {

    @Override
    public Pet toEntity(PetDto petDto) {
        if ( petDto == null ) {
            return null;
        }

        Pet pet = new Pet();

        pet.setVisits( visitDtoListToVisitList( petDto.getVisits() ) );
        pet.setId( petDto.getId() );
        pet.setUser( userDtoToUser( petDto.getUser() ) );
        pet.setName( petDto.getName() );

        return pet;
    }

    @Override
    public PetDto toDto(Pet pet) {
        if ( pet == null ) {
            return null;
        }

        PetDto petDto = new PetDto();

        petDto.setId( pet.getId() );
        petDto.setUser( userToUserDto( pet.getUser() ) );
        petDto.setName( pet.getName() );
        petDto.setVisits( visitListToVisitDtoList( pet.getVisits() ) );

        return petDto;
    }

    @Override
    public Pet partialUpdate(PetDto petDto, Pet pet) {
        if ( petDto == null ) {
            return pet;
        }

        if ( pet.getVisits() != null ) {
            List<Visit> list = visitDtoListToVisitList( petDto.getVisits() );
            if ( list != null ) {
                pet.getVisits().clear();
                pet.getVisits().addAll( list );
            }
        }
        else {
            List<Visit> list = visitDtoListToVisitList( petDto.getVisits() );
            if ( list != null ) {
                pet.setVisits( list );
            }
        }
        if ( petDto.getId() != null ) {
            pet.setId( petDto.getId() );
        }
        if ( petDto.getUser() != null ) {
            if ( pet.getUser() == null ) {
                pet.setUser( new User() );
            }
            userDtoToUser1( petDto.getUser(), pet.getUser() );
        }
        if ( petDto.getName() != null ) {
            pet.setName( petDto.getName() );
        }

        return pet;
    }

    protected Visit visitDtoToVisit(VisitDto visitDto) {
        if ( visitDto == null ) {
            return null;
        }

        Visit visit = new Visit();

        visit.setId( visitDto.getId() );
        visit.setDate( visitDto.getDate() );
        visit.setVeterinarianName( visitDto.getVeterinarianName() );
        visit.setClinicName( visitDto.getClinicName() );

        return visit;
    }

    protected List<Visit> visitDtoListToVisitList(List<VisitDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Visit> list1 = new ArrayList<Visit>( list.size() );
        for ( VisitDto visitDto : list ) {
            list1.add( visitDtoToVisit( visitDto ) );
        }

        return list1;
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );
        user.setPhone( userDto.getPhone() );
        user.setUserStatus( userDto.getUserStatus() );

        return user;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setPhone( user.getPhone() );
        userDto.setUserStatus( user.getUserStatus() );

        return userDto;
    }

    protected VisitDto visitToVisitDto(Visit visit) {
        if ( visit == null ) {
            return null;
        }

        VisitDto visitDto = new VisitDto();

        visitDto.setId( visit.getId() );
        visitDto.setDate( visit.getDate() );
        visitDto.setVeterinarianName( visit.getVeterinarianName() );
        visitDto.setClinicName( visit.getClinicName() );

        return visitDto;
    }

    protected List<VisitDto> visitListToVisitDtoList(List<Visit> list) {
        if ( list == null ) {
            return null;
        }

        List<VisitDto> list1 = new ArrayList<VisitDto>( list.size() );
        for ( Visit visit : list ) {
            list1.add( visitToVisitDto( visit ) );
        }

        return list1;
    }

    protected void userDtoToUser1(UserDto userDto, User mappingTarget) {
        if ( userDto == null ) {
            return;
        }

        if ( userDto.getId() != null ) {
            mappingTarget.setId( userDto.getId() );
        }
        if ( userDto.getUsername() != null ) {
            mappingTarget.setUsername( userDto.getUsername() );
        }
        if ( userDto.getFirstName() != null ) {
            mappingTarget.setFirstName( userDto.getFirstName() );
        }
        if ( userDto.getLastName() != null ) {
            mappingTarget.setLastName( userDto.getLastName() );
        }
        if ( userDto.getEmail() != null ) {
            mappingTarget.setEmail( userDto.getEmail() );
        }
        if ( userDto.getPassword() != null ) {
            mappingTarget.setPassword( userDto.getPassword() );
        }
        if ( userDto.getPhone() != null ) {
            mappingTarget.setPhone( userDto.getPhone() );
        }
        if ( userDto.getUserStatus() != null ) {
            mappingTarget.setUserStatus( userDto.getUserStatus() );
        }
    }
}
