package com.product.toystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.toystore.entity.Promotion;
import com.product.toystore.repository.PromotionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

	@Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Optional<Promotion> getPromotionById(Integer promotionId) {
        return promotionRepository.findById(promotionId);
    }

    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public void deletePromotion(Integer promotionId) {
        promotionRepository.deleteById(promotionId);
    }

    public Promotion updatePromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }
}