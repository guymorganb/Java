
const width = 1600; // Adjust this to match the actual width of your navbar
const height = 175;
const cornerRadius = 30;
const startY = 60; // Starting Y-coordinate
export const SvgPath = `M0,${startY + cornerRadius}
                 A${cornerRadius},${cornerRadius} 0 0 1 ${cornerRadius},${startY}
                 L${width - cornerRadius},${startY}
                 A${cornerRadius},${cornerRadius} 0 0 1 ${width},${startY + cornerRadius}
                 L${width},${height - cornerRadius}
                 A${cornerRadius},${cornerRadius} 0 0 1 ${width - cornerRadius},${height}
                 L${cornerRadius},${height}
                 A${cornerRadius},${cornerRadius} 0 0 1 0,${height - cornerRadius}
                 Z`;
const shiftX = 400; // Shift right by 200px
const shiftY = 80;  // Shift down by 75px

export const AdditionalPathD = `M${29.375 + shiftX},${0 + shiftY} L${4.40625 + shiftX},${0 + shiftY} C${1.9828125 + shiftX},${0 + shiftY} ${0 + shiftX},${1.99431818 + shiftY} ${0 + shiftX},${4.43181818 + shiftY} L${0 + shiftX},${60.5681818 + shiftY} C${0 + shiftX},${63.0056818 + shiftY} ${1.9828125 + shiftX},${65 + shiftY} ${4.40625 + shiftX},${65 + shiftY} L${42.59375 + shiftX},${65 + shiftY} C${45.0171875 + shiftX},${65 + shiftY} ${47 + shiftX},${63.0056818 + shiftY} ${47 + shiftX},${60.5681818 + shiftY} L${47 + shiftX},${17.7272727 + shiftY} L${29.375 + shiftX},${0 + shiftY} Z`;
