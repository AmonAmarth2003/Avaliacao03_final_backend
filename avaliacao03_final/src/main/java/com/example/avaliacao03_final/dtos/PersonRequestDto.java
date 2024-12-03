package com.example.avaliacao03_final.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PersonRequestDto(
    //do not verify spaces in the beginning or end or trim string name before send to Database
    @NotBlank(message="Name cannot be blank")
    @Size(min = 4, message = "Name cannot be shorter than 4 letters")
    @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿ ]+$", message = "Only letters in name")
    String name,
   //regex verify if starts with 00 or not, 55, check the DDD, if is or not a mobile and 8 last digits
   @Pattern(regexp = "([0]{2})?[5]{2}(11|21|48|61|50|51|53|54|55|60|70|80|90|31|32|33|34|35|37|38|27|28|41|42|43|44|45|46|82|68|96)9?[0-9]{8}", message = "invalid contact")
   String contact,
   @NotBlank(message="Gender cannot be blank")
   @Pattern(regexp = "Male|Female", message = "Gender must be 'Male' or 'Female only'")
   String gender
) { }
