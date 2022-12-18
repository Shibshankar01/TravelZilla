package com.travelzilla.services;

import com.travelzilla.exceptions.SessionException;
import com.travelzilla.models.Session;

public interface SessionServices {

	public Session getASessionByKey(String key) throws SessionException;
}
