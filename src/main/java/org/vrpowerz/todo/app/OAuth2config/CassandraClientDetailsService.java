package org.vrpowerz.todo.app.OAuth2config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.vrpowerz.todo.model.OAuth2Client;
import org.vrpowerz.todo.repository.OAuth2ClientRepository;

/**
 * Created on 5/22/16.
 */
@Primary
@Service
public class CassandraClientDetailsService implements ClientDetailsService {

    private OAuth2ClientRepository clientRepository;

    private GrantedAuthorityCreater grantedAuthorityCreater;

    @Autowired
    public void setClientRepository(OAuth2ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    public void setGrantedAuthorityCreater(GrantedAuthorityCreater grantedAuthorityCreater) {
        this.grantedAuthorityCreater = grantedAuthorityCreater;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        final OAuth2Client client = clientRepository.findById(clientId).orElse(null);
        if (client != null) {;
            BaseClientDetails clientDetails = new BaseClientDetails();
            clientDetails.setClientId(client.getClient_id());
            clientDetails.setAuthorizedGrantTypes(client.getGrant_types());
            clientDetails.setClientSecret(client.getClient_secret());
            clientDetails.setScope(client.getScope());
            clientDetails.setAuthorities(grantedAuthorityCreater.fromCollection(client.getAuthorities()));
            return clientDetails;
        } else {
            return null;
        }
    }

}
