package com.project.Banking.Dto;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class AccountDto {
//
//    private long id;
//    private String accountHolderName;
//    private double balance ;
//}

public record AccountDto(long id ,
                         String accountHolderName ,
                         double balance){

}

