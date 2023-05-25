package client.service;

import client.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


public class ItemServiceClient {

    RestTemplate restTemplate = new RestTemplate();
    @Value("${api-client.url}")
    private String serverUrl;

    public ItemDTO findItemById(int itemId) {
        ItemDTO itemDTO = restTemplate.getForObject(serverUrl + "items/{id}", ItemDTO.class, itemId);
        return itemDTO;
    }

    public ItemDTO getAllItems() {
        ItemDTO itemDTO = restTemplate.getForObject(serverUrl + "items", ItemDTO.class);
        return itemDTO;
    }

    public ItemDTO deleteById(int itemId, int customerId) {
        ItemDTO itemDTO = restTemplate.getForObject(serverUrl + "items/{itemId}/{customerId}", ItemDTO.class, itemId, customerId);
        return itemDTO;
    }

    public ItemDTO addItem(ItemDTO itemDTO, MultipartFile imageFile) throws IOException {
        ItemDTO itemDTO2 = restTemplate.getForObject(serverUrl + "items", ItemDTO.class, itemDTO, imageFile);
        return itemDTO2;
    }

    public ItemDTO updateItemById(int id, ItemDTO itemDTO, MultipartFile imageFile) throws IOException {
        ItemDTO itemDTO2 = restTemplate.getForObject(serverUrl + "items/{id}", ItemDTO.class, id,itemDTO, imageFile);
        return itemDTO2;
    }
}
