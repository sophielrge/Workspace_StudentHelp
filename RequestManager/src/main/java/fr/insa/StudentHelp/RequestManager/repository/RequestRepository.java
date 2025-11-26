
package fr.insa.StudentHelp.RequestManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.StudentHelp.RequestManager.model.Request;
import fr.insa.StudentHelp.RequestManager.model.RequestEntity;

public interface RequestRepository extends JpaRepository<Request, Long> {
}