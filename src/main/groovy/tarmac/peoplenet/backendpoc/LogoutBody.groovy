package tarmac.peoplenet.backendpoc

class LogoutBody {

    private String post_logout_redirect_uri
    private String id_token_hint

    LogoutBody() {
    }

    LogoutBody(String post_logout_redirect_uri, String id_token_hint) {
        this.post_logout_redirect_uri = post_logout_redirect_uri
        this.id_token_hint = id_token_hint
    }

    String getPost_logout_redirect_uri() {
        return post_logout_redirect_uri
    }

    void setPost_logout_redirect_uri(String post_logout_redirect_uri) {
        this.post_logout_redirect_uri = post_logout_redirect_uri
    }

    String getId_token_hint() {
        return id_token_hint
    }

    void setId_token_hint(String id_token_hint) {
        this.id_token_hint = id_token_hint
    }
}
