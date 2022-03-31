package uz.coding.appwarhouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import uz.coding.appwarhouse.entity.Attachment;
import uz.coding.appwarhouse.entity.AttachmentContent;

import java.util.Optional;

@Repository
public interface AttachmentContentRepository extends JpaRepository<Attachment, Integer>, JpaSpecificationExecutor<AttachmentContent> {

    Optional<AttachmentContent> findByAttachmentId(Integer id);
}
