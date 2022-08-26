package com.senior.daniel.service;

import com.senior.daniel.dto.ItemDTO;
import com.senior.daniel.model.ItemModel;
import com.senior.daniel.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ItemDTO create(ItemDTO item) {
        item.setId(UUID.randomUUID());
        ItemModel itemModel = modelMapper.map(item, ItemModel.class);
        itemModel = itemRepository.save(itemModel);
        return modelMapper.map(itemModel, ItemDTO.class);
    }

    public ItemDTO read(UUID id) {
        Optional<ItemModel> optional = itemRepository.findById(id);
        if (optional.isPresent()) {
            return modelMapper.map(optional.get(), ItemDTO.class);
        }
        return null;
    }

    public ItemDTO udpate(UUID id, ItemDTO itemDTO) {
        Optional<ItemModel> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            itemDTO.setId(optionalItem.get().getId());
            ItemModel itemModel = modelMapper.map(itemDTO, ItemModel.class);
            itemModel = itemRepository.save(itemModel);
            return modelMapper.map(itemModel, ItemDTO.class);
        }
        return null;
    }

    public void delete(UUID id) {
        itemRepository.deleteById(id);
    }

    public List<ItemDTO> list() {
        List<ItemDTO> itemDTOS = new ArrayList<>();
        List<ItemModel> itemModelList =  itemRepository.findAll();
        itemModelList.forEach(itemModel -> {
            itemDTOS.add(modelMapper.map(itemModel, ItemDTO.class));
        });
        return itemDTOS;
    }

}
