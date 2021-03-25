package net.codejava.versions;

import net.codejava.subjects.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionsRepository extends JpaRepository<Versions, Long> {
}
