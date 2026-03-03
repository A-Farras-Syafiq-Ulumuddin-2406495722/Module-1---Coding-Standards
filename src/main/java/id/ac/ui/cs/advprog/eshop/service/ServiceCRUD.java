package id.ac.ui.cs.advprog.eshop.service;


public interface ServiceCRUD<T> {
    public T create(T obj);
    public void update(String id, T obj);
    public void deleteById(String id);
}
