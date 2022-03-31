package uz.coding.appwarhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.coding.appwarhouse.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
