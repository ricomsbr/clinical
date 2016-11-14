package br.com.ackta.clinical.application.security;

import org.bson.types.ObjectId;

public interface IUserLogin {

	ObjectId getId();

	String getName();

}
