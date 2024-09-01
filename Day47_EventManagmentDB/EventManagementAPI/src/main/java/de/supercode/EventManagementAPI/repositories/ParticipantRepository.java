package de.supercode.EventManagementAPI.repositories;

import de.supercode.EventManagementAPI.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
