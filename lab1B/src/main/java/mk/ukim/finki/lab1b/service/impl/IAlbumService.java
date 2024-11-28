package mk.ukim.finki.lab1b.service.impl;

import mk.ukim.finki.lab1b.model.Album;
import mk.ukim.finki.lab1b.repository.AlbumRepository;
import mk.ukim.finki.lab1b.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAlbumService implements AlbumService {
    private final AlbumRepository albumRepository;

    public IAlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }
}
