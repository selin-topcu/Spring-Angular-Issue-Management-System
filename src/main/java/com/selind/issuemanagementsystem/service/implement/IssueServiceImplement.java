package com.selind.issuemanagementsystem.service.implement;

import com.selind.issuemanagementsystem.dto.IssueDto;
import com.selind.issuemanagementsystem.dto.ProjectDto;
import com.selind.issuemanagementsystem.entity.Issue;
import com.selind.issuemanagementsystem.entity.Project;
import com.selind.issuemanagementsystem.repository.IssueRepository;
import com.selind.issuemanagementsystem.service.IssueService;
import com.selind.issuemanagementsystem.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImplement implements IssueService {

    //IssueRepository kullanabilmek için constructor kullanıldı. @Autowired kullanılmamasının sebebi aşağıdaki yöntemde anlatılmıştır.
    private final IssueRepository issueRepository;//final daha sonradan değiştirilmesini engellemek için kullanılır, nesneyi güvenilir hale getirir. constructor da sadece nesneye atama yapılabilir
    private final ModelMapper modelMapper;
    public IssueServiceImplement(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate()==null){
            throw new IllegalArgumentException("Issue Date Cannot be date null");
        }
        Issue issueDB= modelMapper.map(issue, Issue.class); //IssueDto içindeki properties isimleri ile Issue.java içindeki isimleri eşleştiriyor
        issueDB=issueRepository.save(issueDB); //veritaanına kaydetme işlemini yapar
        return modelMapper.map(issueDB, IssueDto.class); //kaydedilen veri ile IssueDto içindeki properties isimlerini eşleştiriyor
        //service dışına yani api katmanına doğru çıkarken entity katmanını dışarıya çıkarmıyoruz onun yerine dto katmanını kullanıyoru. Serviceden önce ise entity katmanı kullanılır dto değil

    }

    @Override
    public IssueDto getById(Long id) {
        Issue p= issueRepository.getById(id);
        return modelMapper.map(p, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
      Page<Issue> data=issueRepository.findAll(pageable);
      TPage page= new TPage<IssueDto>();
      IssueDto[] dtos=modelMapper.map(data.getContent(),IssueDto[].class);
      page.setStat(data, Arrays.asList(dtos));
      return page;
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }

    @Override
    public IssueDto update(Long id, IssueDto project) {
        return null;
    }
}
