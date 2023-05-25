package client.service;

import client.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ServiceServiceClient {
    RestTemplate restTemplate = new RestTemplate();
    @Value("${api-client.url}")
    private String serverUrl;

    public ReviewDTO addReview(ReviewDTO review, int itemId, int customerId) {
        ReviewDTO reviewDTO = restTemplate.getForObject(serverUrl + "review/{itemId}/{customerId}", ReviewDTO.class, review, itemId, customerId);
        return reviewDTO;
    }

    public ReviewDTO getReviewsByItem(int itemId) {
        ReviewDTO reviewDTO = restTemplate.getForObject(serverUrl + "review/{itemId}", ReviewDTO.class, itemId);
        return reviewDTO;
    }

    public ReviewDTO getReviewsByCustomerId(int customerId) {
        ReviewDTO reviewDTO = restTemplate.getForObject(serverUrl + "review/{customerId}", ReviewDTO.class, customerId);
        return reviewDTO;
    }

    public ReviewDTO getReviewById(int reviewId) {
        ReviewDTO reviewDTO = restTemplate.getForObject(serverUrl + "review/{customerId}", ReviewDTO.class, reviewId);
        return reviewDTO;
    }
    public ReviewDTO updateReviewById(int reviewId, ReviewDTO reviewDTO2) {
        ReviewDTO reviewDTO = restTemplate.getForObject(serverUrl + "review/{reviewId}", ReviewDTO.class, reviewId, reviewDTO2);
        return reviewDTO;
    }

    public ReviewDTO deleteReviewById(int id) {
        ReviewDTO reviewDTO = restTemplate.getForObject(serverUrl + "review/{reviewId}", ReviewDTO.class, id);
        return reviewDTO;
    }
}
