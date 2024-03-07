# PetApi

All URIs are relative to *https://petclinic.swagger.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addPet**](PetApi.md#addPet) | **POST** /pet | Add a new pet to the clinic
[**deletePet**](PetApi.md#deletePet) | **DELETE** /pet/{petId} | Deletes a pet
[**findPetsByStatus**](PetApi.md#findPetsByStatus) | **GET** /pet/findByStatus | Finds Pets by status
[**getPetById**](PetApi.md#getPetById) | **GET** /pet/{petId} | Find pet by ID
[**updatePet**](PetApi.md#updatePet) | **PUT** /pet | Update an existing pet
[**updatePetWithForm**](PetApi.md#updatePetWithForm) | **POST** /pet/{petId} | Updates a pet in the clinic with form data
[**uploadFile**](PetApi.md#uploadFile) | **POST** /pet/{petId}/uploadImage | uploads an image

<a name="addPet"></a>
# **addPet**
> addPet(body)

Add a new pet to the clinic

### Example
```java
// Import classes:
//import com.swagger.client.codegen.rest.invoker.ApiClient;
//import com.swagger.client.codegen.rest.invoker.ApiException;
//import com.swagger.client.codegen.rest.invoker.Configuration;
//import com.swagger.client.codegen.rest.invoker.auth.*;
//import com.swagger.client.codegen.rest.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petclinic_auth
OAuth petclinic_auth = (OAuth) defaultClient.getAuthentication("petclinic_auth");
petclinic_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
PetDto body = new PetDto(); // PetDto | Pet object that needs to be added to the clinic
try {
    apiInstance.addPet(body);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#addPet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PetDto**](PetDto.md)| Pet object that needs to be added to the clinic |

### Return type

null (empty response body)

### Authorization

[petclinic_auth](../README.md#petclinic_auth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

<a name="deletePet"></a>
# **deletePet**
> deletePet(petId, apiKey)

Deletes a pet

### Example
```java
// Import classes:
//import com.swagger.client.codegen.rest.invoker.ApiClient;
//import com.swagger.client.codegen.rest.invoker.ApiException;
//import com.swagger.client.codegen.rest.invoker.Configuration;
//import com.swagger.client.codegen.rest.invoker.auth.*;
//import com.swagger.client.codegen.rest.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petclinic_auth
OAuth petclinic_auth = (OAuth) defaultClient.getAuthentication("petclinic_auth");
petclinic_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
Long petId = 789L; // Long | Pet id to delete
String apiKey = "apiKey_example"; // String | 
try {
    apiInstance.deletePet(petId, apiKey);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#deletePet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **petId** | **Long**| Pet id to delete |
 **apiKey** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[petclinic_auth](../README.md#petclinic_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="findPetsByStatus"></a>
# **findPetsByStatus**
> List&lt;PetDto&gt; findPetsByStatus(status)

Finds Pets by status

Multiple status values can be provided with comma separated strings

### Example
```java
// Import classes:
//import com.swagger.client.codegen.rest.invoker.ApiClient;
//import com.swagger.client.codegen.rest.invoker.ApiException;
//import com.swagger.client.codegen.rest.invoker.Configuration;
//import com.swagger.client.codegen.rest.invoker.auth.*;
//import com.swagger.client.codegen.rest.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petclinic_auth
OAuth petclinic_auth = (OAuth) defaultClient.getAuthentication("petclinic_auth");
petclinic_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
List<String> status = Arrays.asList("status_example"); // List<String> | Status values that need to be considered for filter
try {
    List<PetDto> result = apiInstance.findPetsByStatus(status);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#findPetsByStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**List&lt;String&gt;**](String.md)| Status values that need to be considered for filter | [enum: available, pending, sold]

### Return type

[**List&lt;PetDto&gt;**](PetDto.md)

### Authorization

[petclinic_auth](../README.md#petclinic_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="getPetById"></a>
# **getPetById**
> PetDto getPetById(petId)

Find pet by ID

Returns a single pet

### Example
```java
// Import classes:
//import com.swagger.client.codegen.rest.invoker.ApiClient;
//import com.swagger.client.codegen.rest.invoker.ApiException;
//import com.swagger.client.codegen.rest.invoker.Configuration;
//import com.swagger.client.codegen.rest.invoker.auth.*;
//import com.swagger.client.codegen.rest.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

PetApi apiInstance = new PetApi();
Long petId = 789L; // Long | ID of pet to return
try {
    PetDto result = apiInstance.getPetById(petId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#getPetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **petId** | **Long**| ID of pet to return |

### Return type

[**PetDto**](PetDto.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="updatePet"></a>
# **updatePet**
> updatePet(body)

Update an existing pet

### Example
```java
// Import classes:
//import com.swagger.client.codegen.rest.invoker.ApiClient;
//import com.swagger.client.codegen.rest.invoker.ApiException;
//import com.swagger.client.codegen.rest.invoker.Configuration;
//import com.swagger.client.codegen.rest.invoker.auth.*;
//import com.swagger.client.codegen.rest.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petclinic_auth
OAuth petclinic_auth = (OAuth) defaultClient.getAuthentication("petclinic_auth");
petclinic_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
PetDto body = new PetDto(); // PetDto | Pet object that needs to be added to the clinic
try {
    apiInstance.updatePet(body);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#updatePet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PetDto**](PetDto.md)| Pet object that needs to be added to the clinic |

### Return type

null (empty response body)

### Authorization

[petclinic_auth](../README.md#petclinic_auth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined

<a name="updatePetWithForm"></a>
# **updatePetWithForm**
> updatePetWithForm(petId, name, status)

Updates a pet in the clinic with form data

### Example
```java
// Import classes:
//import com.swagger.client.codegen.rest.invoker.ApiClient;
//import com.swagger.client.codegen.rest.invoker.ApiException;
//import com.swagger.client.codegen.rest.invoker.Configuration;
//import com.swagger.client.codegen.rest.invoker.auth.*;
//import com.swagger.client.codegen.rest.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petclinic_auth
OAuth petclinic_auth = (OAuth) defaultClient.getAuthentication("petclinic_auth");
petclinic_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
Long petId = 789L; // Long | ID of pet that needs to be updated
String name = "name_example"; // String | 
String status = "status_example"; // String | 
try {
    apiInstance.updatePetWithForm(petId, name, status);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#updatePetWithForm");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **petId** | **Long**| ID of pet that needs to be updated |
 **name** | **String**|  | [optional]
 **status** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

[petclinic_auth](../README.md#petclinic_auth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: Not defined

<a name="uploadFile"></a>
# **uploadFile**
> ModelApiResponse uploadFile(petId, additionalMetadata, file)

uploads an image

### Example
```java
// Import classes:
//import com.swagger.client.codegen.rest.invoker.ApiClient;
//import com.swagger.client.codegen.rest.invoker.ApiException;
//import com.swagger.client.codegen.rest.invoker.Configuration;
//import com.swagger.client.codegen.rest.invoker.auth.*;
//import com.swagger.client.codegen.rest.api.PetApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: petclinic_auth
OAuth petclinic_auth = (OAuth) defaultClient.getAuthentication("petclinic_auth");
petclinic_auth.setAccessToken("YOUR ACCESS TOKEN");

PetApi apiInstance = new PetApi();
Long petId = 789L; // Long | ID of pet to update
String additionalMetadata = "additionalMetadata_example"; // String | 
File file = new File("file_example"); // File | 
try {
    ModelApiResponse result = apiInstance.uploadFile(petId, additionalMetadata, file);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PetApi#uploadFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **petId** | **Long**| ID of pet to update |
 **additionalMetadata** | **String**|  | [optional]
 **file** | **File**|  | [optional]

### Return type

[**ModelApiResponse**](ModelApiResponse.md)

### Authorization

[petclinic_auth](../README.md#petclinic_auth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

