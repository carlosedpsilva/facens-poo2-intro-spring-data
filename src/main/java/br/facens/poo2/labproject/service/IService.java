package br.facens.poo2.labproject.service;

import java.util.List;

public interface IService<T, E, R, W> {

  List<E> toDTOList(List<T> list);

  T existsById(Long id);

  List<E> findAll();

  E findById(Long id);

  T save(R insertDTO);

  void delete(Long id);

  T update(Long id, W updateDTO);

}
