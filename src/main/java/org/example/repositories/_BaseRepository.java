package org.example.repositories;

import org.example.entities._BaseEntity;

import java.util.List;

public interface _BaseRepository <T extends _BaseEntity>{
    public void Create(T entity);
    public void Update(T entity);
    public void Delete(T entity);
    public List<T> ReadAll();
    public T FindById(int id);
}
