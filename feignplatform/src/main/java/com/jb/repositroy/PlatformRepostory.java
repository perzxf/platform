package com.jb.repositroy;

import com.jb.entity.CustomBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface PlatformRepostory extends ElasticsearchCrudRepository<CustomBean,String> {
}
