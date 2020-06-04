package com.m.g.ui.model;

import com.m.g.ui.jpa.model.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class UserForm {

  private ArrayList<UserEntity> users;

}
