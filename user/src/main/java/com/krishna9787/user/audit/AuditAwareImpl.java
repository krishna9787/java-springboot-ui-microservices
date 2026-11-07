package com.krishna9787.user.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Implement logic to retrieve the current auditor (e.g., from security context)
        return Optional.of("system"); // Placeholder value, replace with actual implementation
    }

}
