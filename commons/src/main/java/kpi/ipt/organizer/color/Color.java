package kpi.ipt.organizer.color;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Color {

    // Format: 00RRGGBB, where
    // RR - byte for read channel,
    // GG - byte for green channel,
    // BB - byte for blue channel
    private int value;

    @Override
    public String toString() {
        return "Color(" + ColorUtils.toWebString(this) + ')';
    }
}
