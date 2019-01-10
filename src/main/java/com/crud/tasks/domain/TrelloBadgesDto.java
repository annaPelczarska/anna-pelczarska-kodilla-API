package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrelloBadgesDto {
    @JsonProperty(value = "votes")
    private int votes;
    @JsonProperty(value = "attachmentsByType")
    private AttachmentByTypeDto attachment;
}
