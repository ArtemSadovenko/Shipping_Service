package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
