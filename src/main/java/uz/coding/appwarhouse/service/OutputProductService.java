package uz.coding.appwarhouse.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.coding.appwarhouse.entity.*;
import uz.coding.appwarhouse.payload.ApiResponse;
import uz.coding.appwarhouse.payload.OutputProductDto;
import uz.coding.appwarhouse.repository.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService<SummaRepository> {
    private  final OutputProductRepository outputProductRepository;
    private final OutputRepository outputRepository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;
    private final InputProductRepository inputProductRepository;
    private final uz.coding.appwarhouse.repository.SummaRepository summaRepository;
    @Autowired
    public OutputProductService(OutputProductRepository outputProductRepository, OutputRepository outputRepository, ProductRepository productRepository, WarehouseRepository warehouseRepository, InputProductRepository inputProductRepository, uz.coding.appwarhouse.repository.SummaRepository summaRepository) {
        this.outputProductRepository = outputProductRepository;
        this.outputRepository = outputRepository;
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
        this.inputProductRepository = inputProductRepository;
        this.summaRepository = (uz.coding.appwarhouse.repository.SummaRepository) summaRepository;
    }

    public ApiResponse addOutputProduct(OutputProductDto outputProductDto) {
        Optional<uz.coding.appwarhouse.entity.Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (!optionalOutput.isPresent())
            return new ApiResponse("Output not found",false);
        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new ApiResponse("Product Not found",false);
        OutputProduct outputProduct = new OutputProduct();
        uz.coding.appwarhouse.entity.Output output = optionalOutput.get();
        Warehouse warehouse = output.getWarehouse();
        Integer id = warehouse.getId();
        Integer id1 = optionalProduct.get().getId();
        if (!summaRepository.existsByWarehousesIdInAndProductsIdIn(Collections.singletonList(id), Collections.singletonList(id1)))
            return new ApiResponse("bu omborda bunday mahsult qolmagan ",false);
        Optional<Summa> optionalSumma = summaRepository.findByWarehousesIdInAndProductsIdIn(Collections.singletonList(id), Collections.singletonList(id1));
        Summa summa = optionalSumma.get();
        double summa1 = summa.getSumma();
        if (summa1>outputProductDto.getAmount()){
            outputProduct.setOutput(optionalOutput.get());
            outputProduct.setProduct(optionalProduct.get());
            outputProduct.setPrice(outputProductDto.getPrice());
            outputProduct.setAmount(outputProductDto.getAmount());
            outputProductRepository.save(outputProduct);
            summa.setSumma(summa.getSumma()-outputProductDto.getAmount());
            summaRepository.save(summa);
            return new ApiResponse("OutputProduct added",true);
        }
        return new ApiResponse("bazda mahsulotlar bu miqdordan kam ",false);
    }

    public ApiResponse editOutputProduct(Integer id,OutputProductDto outputProductDto){
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (!optionalOutputProduct.isPresent())
            return new ApiResponse("OutputProduct not found",false);
        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (!optionalOutput.isPresent())
            return new ApiResponse("Output not found",false);
        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new ApiResponse("Product Not found",false);
        Output output = optionalOutput.get();
        Product product = optionalProduct.get();
        OutputProduct outputProduct = optionalOutputProduct.get();
        outputProduct.setProduct(product);
        outputProduct.setOutput(output);
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProductRepository.save(outputProduct);
        return new ApiResponse("Successfully edited",true);
    }

    public List<OutputProduct> getByOutputId(Integer outputId){
        if (outputRepository.findById(outputId).isPresent()){
            return outputProductRepository.getAllByOutputId(outputId);
        }
        return new ArrayList<>();
    }
    public List<OutputProduct> getByWarehouseId(Integer warehouseId){
        if (warehouseRepository.findById(warehouseId).isPresent()){
            return outputProductRepository.getAllByOutput_WarehouseId(warehouseId);
        }
        return new ArrayList<>();
    }

    public ApiResponse deletedOutput(Integer id){
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (optionalOutputProduct.isPresent()){
            outputProductRepository.deleteById(id);
            return new ApiResponse("Successfully deleted",false);
        }

        return new ApiResponse("Erorr deleted",false);




    }
}
