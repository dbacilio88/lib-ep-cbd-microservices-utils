package pe.mil.microservices.utils.service.interfaces;

public interface IGetAllDomainEntity<L> {

    L getAll();

    Iterable<L> getAllEntities();
}
