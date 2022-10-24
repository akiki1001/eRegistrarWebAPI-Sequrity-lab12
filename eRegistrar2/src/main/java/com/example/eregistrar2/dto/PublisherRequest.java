package com.example.eregistrar2.dto;

import edu.miu.cs.cs425.fairfieldlibraryjwtsecuredwebapi.model.PrimaryAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * This class defines a DTO for Publisher data
 * as will be expected from the Web API Client
 */
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class PublisherRequest {
    @NotBlank(message = "Publisher name cannot be null, empty or blank")
    private String name;
    private PrimaryAddress primaryAddress;
}
