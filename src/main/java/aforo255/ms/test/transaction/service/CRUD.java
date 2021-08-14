package aforo255.ms.test.transaction.service;

public interface CRUD<E> {

    public E findById(Long id);

    public E save(E record);

    public Iterable<E> findAll();
}
