package org.example.repositories;

import org.example.entities._BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class _BaseRepositoryImpl <T extends _BaseEntity> implements _BaseRepository<T> {
    List<T> entities = new ArrayList<>();

    @Override
    public void Create(T entity) {
        entities.add(entity);
    }

    @Override
    public void Update(T entity) {
        Delete(entity);
        Create(entity);
    }

    @Override
    public void Delete(T entity) {
        entities.removeIf(item -> item.getId() == entity.getId());
    }

    @Override
    public List<T> ReadAll() {
        return entities;
    }

    @Override
    public T FindById(int id) {
        return entities.stream()
                .filter(entity -> entity.getId() == (id))
                .findFirst()
                .orElse(null);
    }
}
