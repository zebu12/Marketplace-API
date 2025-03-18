package se.lexicon.marketplaceapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.marketplaceapi.dto.UserDTORequest;
import se.lexicon.marketplaceapi.dto.UserDTOResponse;
import se.lexicon.marketplaceapi.dtoConverter.DtoConverter;
import se.lexicon.marketplaceapi.entity.User;
import se.lexicon.marketplaceapi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(summary = "create user")
    @ApiResponse(responseCode = "200" ,description = "created successfully")
    @ApiResponse(responseCode = "400" , description = "valid input")
    public ResponseEntity<UserDTOResponse> createUser(@Valid @RequestBody UserDTORequest userDTORequest) {
        User user =userService.register(userDTORequest.getEmail(), userDTORequest.getPassword());
        UserDTOResponse userDTOResponse = DtoConverter.covertUserDTO(user);
        return ResponseEntity.ok(userDTOResponse);
    }
}
