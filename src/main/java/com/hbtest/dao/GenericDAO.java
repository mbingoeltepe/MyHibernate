package com.hbtest.dao;

import java.io.Serializable;

public interface GenericDAO<T, ID extends Serializable> {

   public void  makePersistent(T entity);
 
}
