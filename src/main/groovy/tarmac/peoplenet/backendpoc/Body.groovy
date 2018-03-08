package tarmac.peoplenet.backendpoc

class Body {

    private String grant_type
    private String code
    private String redirect_uri
    private String client_id
    private String client_secret
    private String tenantDomain

    Body(){

    }

    Body(String grant_type, String code, String redirect_uri, String client_id, String client_secret, String tenantDomain) {
        this.grant_type = grant_type
        this.code = code
        this.redirect_uri = redirect_uri
        this.client_id = client_id
        this.client_secret = client_secret
        this.tenantDomain = tenantDomain
    }

    String getGrant_type() {
        return grant_type
    }

    void setGrant_type(String grant_type) {
        this.grant_type = grant_type
    }

    String getCode() {
        return code
    }

    void setCode(String code) {
        this.code = code
    }

    String getRedirect_uri() {
        return redirect_uri
    }

    void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri
    }

    String getClient_id() {
        return client_id
    }

    void setClient_id(String client_id) {
        this.client_id = client_id
    }

    String getClient_secret() {
        return client_secret
    }

    void setClient_secret(String client_secret) {
        this.client_secret = client_secret
    }

    String getTenantDomain() {
        return tenantDomain
    }

    void setTenantDomain(String tenantDomain) {
        this.tenantDomain = tenantDomain
    }
}
