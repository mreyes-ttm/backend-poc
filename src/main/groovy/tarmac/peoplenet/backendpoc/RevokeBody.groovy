package tarmac.peoplenet.backendpoc

class RevokeBody {

    private String token
    private String token_type_hint

    RevokeBody() {
    }

    RevokeBody(String token, String token_type_hint) {
        this.token = token
        this.token_type_hint = token_type_hint
    }

    String getToken() {
        return token
    }

    void setToken(String token) {
        this.token = token
    }

    String getToken_type_hint() {
        return token_type_hint
    }

    void setToken_type_hint(String token_type_hint) {
        this.token_type_hint = token_type_hint
    }
}
