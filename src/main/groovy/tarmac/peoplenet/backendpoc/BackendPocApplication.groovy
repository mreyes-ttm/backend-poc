package tarmac.peoplenet.backendpoc

import org.apache.http.HttpEntity
import org.apache.http.NameValuePair
import org.apache.http.util.EntityUtils
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.message.BasicNameValuePair
import org.apache.http.impl.client.HttpClientBuilder

@SpringBootApplication
@RestController
@CrossOrigin
@EnableAutoConfiguration
class BackendPocApplication {


    @RequestMapping("/")
    String index() {
        return "Welcome to the POC backend"
    }

    @RequestMapping(value = "/paccarLogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String tokenRequest(@RequestBody Body body, @RequestHeader HttpHeaders headers) {

        HttpClient httpClient = HttpClientBuilder.create().build()
        HttpPost request = new HttpPost("https://www-cert.epaccar.com/PortalSSO/connect/token")

        request.addHeader(HttpHeaders.ACCEPT, 'application/json')
        request.addHeader(HttpHeaders.CONTENT_TYPE,'application/x-www-form-urlencoded')
        request.addHeader(HttpHeaders.AUTHORIZATION, headers.get(HttpHeaders.AUTHORIZATION).first())
        request.addHeader(HttpHeaders.CACHE_CONTROL, 'no-cache')

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>()
        nameValuePairs.add(new BasicNameValuePair("grant_type", body.grant_type))
        nameValuePairs.add(new BasicNameValuePair("code", body.code))
        nameValuePairs.add(new BasicNameValuePair("redirect_uri", body.redirect_uri))
        nameValuePairs.add(new BasicNameValuePair("client_key", body.client_id))
        nameValuePairs.add(new BasicNameValuePair("client_secret", body.client_secret))
        nameValuePairs.add(new BasicNameValuePair("tenantDomain", body.tenantDomain))
        request.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"))

        HttpResponse response = httpClient.execute(request)
        HttpEntity entity = response.getEntity()
        return EntityUtils.toString(entity)
    }

    @RequestMapping(value = "/paccarLogout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String logout(@RequestBody LogoutBody body, @RequestHeader HttpHeaders headers) {

        HttpClient httpClient = HttpClientBuilder.create().build()
        HttpPost request = new HttpPost("https://www-cert.epaccar.com/PortalSSO/connect/endsession")

        request.addHeader(HttpHeaders.ACCEPT, 'application/json')
        request.addHeader(HttpHeaders.CONTENT_TYPE,'application/x-www-form-urlencoded')
        request.addHeader(HttpHeaders.AUTHORIZATION, headers.get(HttpHeaders.AUTHORIZATION).first())
        request.addHeader(HttpHeaders.CACHE_CONTROL, 'no-cache')


        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>()
        nameValuePairs.add(new BasicNameValuePair("post_logout_redirect_uri", body.post_logout_redirect_uri))
        nameValuePairs.add(new BasicNameValuePair("id_token_hint", body.id_token_hint))
        request.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"))

        HttpResponse response = httpClient.execute(request)
        HttpEntity entity = response.getEntity()
        return EntityUtils.toString(entity)
    }

    @RequestMapping(value = "/paccarRevoke", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String revokeToken(@RequestBody RevokeBody body, @RequestHeader HttpHeaders headers) {

        HttpClient httpClient = HttpClientBuilder.create().build()
        HttpPost request = new HttpPost("https://www-cert.epaccar.com/PortalSSO/connect/revocation")

        request.addHeader(HttpHeaders.ACCEPT, 'application/json')
        request.addHeader(HttpHeaders.CONTENT_TYPE,'application/x-www-form-urlencoded')
        request.addHeader(HttpHeaders.AUTHORIZATION, headers.get(HttpHeaders.AUTHORIZATION).first())
        request.addHeader(HttpHeaders.CACHE_CONTROL, 'no-cache')


        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>()
        nameValuePairs.add(new BasicNameValuePair("token", body.token))
        nameValuePairs.add(new BasicNameValuePair("token_type_hint", body.token_type_hint))
        request.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"))

        HttpResponse response = httpClient.execute(request)
        HttpEntity entity = response.getEntity()
        return EntityUtils.toString(entity)
    }

	static void main(String[] args) {
		SpringApplication.run BackendPocApplication, args
	}
}
