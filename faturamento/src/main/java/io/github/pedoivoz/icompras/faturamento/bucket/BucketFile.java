package io.github.pedoivoz.icompras.faturamento;

import io.minio.MinioClient;
import org.springframework.http.MediaType;

import java.io.InputStream;

public record BucketFile(String name, InputStream is, MediaType type, Long size) {
}
